/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.atlas.repository.store.graph;

import org.apache.atlas.exception.AtlasBaseException;
import org.apache.atlas.model.SearchFilter;
import org.apache.atlas.model.typedef.AtlasClassificationDef;
import org.apache.atlas.model.typedef.AtlasClassificationDef.AtlasClassificationDefs;

import java.util.List;

/**
 * Interface for graph persistence store for AtlasClassificationDef
 */
public interface AtlasClassificationDefStore {
    AtlasClassificationDef create(AtlasClassificationDef classificationDef) throws AtlasBaseException;

    List<AtlasClassificationDef> create(List<AtlasClassificationDef> classificationDefs) throws AtlasBaseException;

    List<AtlasClassificationDef> getAll() throws AtlasBaseException;

    AtlasClassificationDef getByName(String name) throws AtlasBaseException;

    AtlasClassificationDef getByGuid(String guid) throws AtlasBaseException;

    AtlasClassificationDef updateByName(String name, AtlasClassificationDef classificationDef) throws AtlasBaseException;

    AtlasClassificationDef updateByGuid(String guid, AtlasClassificationDef classificationDef) throws AtlasBaseException;

    List<AtlasClassificationDef> update(List<AtlasClassificationDef> classificationDefs) throws AtlasBaseException;

    void deleteByName(String name) throws AtlasBaseException;

    void deleteByNames(List<String> names) throws AtlasBaseException;

    void deleteByGuid(String guid) throws AtlasBaseException;

    void deleteByGuids(List<String> guids) throws AtlasBaseException;

    AtlasClassificationDefs search(SearchFilter filter) throws AtlasBaseException;
}
