/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.atlas;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.atlas.discovery.HdfsAtlasDiscoveryService;
import org.testng.annotations.Test;

/**
 *
 */
public class AtlasDiscoveryServiceIT {
  private HdfsAtlasDiscoveryService discoveryService;

  protected AtlasClient   atlasClientV1;
  protected AtlasClientV2 atlasClientV2;
  private String atlasUrls[] = new String[]{"http://localhost:21000/"};


  @Test
  public void testPortSelection () throws Exception {
    atlasClientV1 = new AtlasClient(atlasUrls, new String[]{"admin", "admin"});
    atlasClientV2 = new AtlasClientV2(atlasUrls, new String[]{"admin", "admin"});

    ArrayNode node = atlasClientV1.searchByDSL("from fs_path where name like 'hdfs://ns1/data/test1a'", 1, 0);
    System.out.println(node);
  }

}
