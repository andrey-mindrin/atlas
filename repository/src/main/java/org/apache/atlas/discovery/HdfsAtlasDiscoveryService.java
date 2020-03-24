package org.apache.atlas.discovery;

import org.apache.atlas.annotation.GraphTransaction;
import org.apache.atlas.exception.AtlasBaseException;
import org.apache.atlas.model.discovery.AtlasSearchResult;
import org.apache.atlas.model.discovery.SearchParameters;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class HdfsAtlasDiscoveryService {
    private EntityDiscoveryService entityDiscoveryService;

    @Inject
    public HdfsAtlasDiscoveryService(EntityDiscoveryService entityDiscoveryService) {
        this.entityDiscoveryService = entityDiscoveryService;
    }

    @GraphTransaction
    public AtlasSearchResult searchWithParameters(String query) throws AtlasBaseException {
        SearchParameters parameters = new SearchParameters();
        parameters.setQuery(query);
        parameters.setExcludeDeletedEntities(true);
        parameters.setIncludeSubClassifications(true);
        parameters.setIncludeSubTypes(true);
        parameters.setLimit(25);
        parameters.setOffset(0);

        return entityDiscoveryService.searchWithParameters(parameters);
    }
}
