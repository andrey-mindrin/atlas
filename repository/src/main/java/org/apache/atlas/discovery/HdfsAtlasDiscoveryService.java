package org.apache.atlas.discovery;

import org.apache.atlas.annotation.GraphTransaction;
import org.apache.atlas.exception.AtlasBaseException;
import org.apache.atlas.model.discovery.AtlasSearchResult;
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
        String q = "from hive_storagedesc where location like '" + query + "'";
        return discoveryService.searchUsingDslQuery(q, 25, 0);
    }
}
