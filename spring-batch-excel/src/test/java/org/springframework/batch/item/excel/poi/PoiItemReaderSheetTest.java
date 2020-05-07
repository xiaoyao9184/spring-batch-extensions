/*
 * Copyright 2006-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.batch.item.excel.poi;

import org.springframework.batch.item.excel.AbstractExcelItemReader;
import org.springframework.batch.item.excel.AbstractExcelItemReaderTests;
import org.springframework.core.io.ClassPathResource;

public class PoiItemReaderSheetTest extends AbstractExcelItemReaderTests {

    /**
     * Adjust sheet order, sheet 0 is an empty
     * The number of headers and data columns are different
     */
    @Override
    protected void configureItemReader(AbstractExcelItemReader itemReader) {
        itemReader.setResource(new ClassPathResource("org/springframework/batch/item/excel/player-2sheet.xlsx"));
    }

    @Override
    protected AbstractExcelItemReader createExcelItemReader() {
        PoiItemReader reader = new PoiItemReader();
        reader.setCurrentSheet(1);
        reader.setMaxSheet(1);
        reader.setLinesToSkip(1);
        reader.setRowForColumnCount(1);
        return reader;
    }

}
