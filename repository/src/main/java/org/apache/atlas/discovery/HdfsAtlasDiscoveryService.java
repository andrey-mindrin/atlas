package org.apache.atlas.discovery;

import java.util.HashSet;
import org.apache.atlas.annotation.GraphTransaction;
import org.apache.atlas.exception.AtlasBaseException;
import org.apache.atlas.model.discovery.AtlasSearchResult;
import org.apache.atlas.model.discovery.SearchParameters;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class HdfsAtlasDiscoveryService {
    private static final Logger LOG  = LoggerFactory.getLogger(HdfsAtlasDiscoveryService.class);
    private AtlasDiscoveryService discoveryService;

    @Inject
    public HdfsAtlasDiscoveryService(AtlasDiscoveryService discoveryService) {
        this.discoveryService = discoveryService;
    }

    @GraphTransaction
    public AtlasSearchResult searchWithParameters(String query) throws AtlasBaseException {
        SearchParameters parameters = new SearchParameters();
        parameters.setQuery(escapeQuery(query));
        parameters.setExcludeDeletedEntities(true);
        parameters.setIncludeSubClassifications(true);
        parameters.setIncludeSubTypes(true);
        parameters.setLimit(25);
        parameters.setOffset(0);
        parameters.setAttributes(new HashSet<>());
        parameters.setTypeName("hive_storagedesc");
        LOG.info("QUERY :"+parameters.getQuery());
        LOG.info("SearchParameters :"+parameters.toString());

        return discoveryService.searchWithParameters(parameters);
    }
    private  String escapeQuery(String sourceQuery) {
        return QueryParser.escape(sourceQuery);
    }
}
