/*
 * Copyright (C) 2023 The ORT Project Authors (See <https://github.com/oss-review-toolkit/ort-server/blob/main/NOTICE>)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */

package org.ossreviewtoolkit.model

import com.fasterxml.jackson.annotation.JsonInclude

import org.ossreviewtoolkit.utils.spdx.SpdxExpression

data class Snippet(
    /**
     * The matching score between the code being scanned and the code snippet. This is scanner specific (e.g. for
     * ScanOSS this is a percentage).
     */
    val score: Float,

    /**
     * The text location in the snippet that has matched.
     */
    val location: TextLocation,

    /**
     * The provenance of the snippet, either an artifact or a repository.
     */
    val provenance: KnownProvenance,

    /**
     * The purl representing the author/vendor, artifact, version of the code snippet. If the snippet scanner does not
     * natively support purls, it will be generated by ORT.
     */
    val purl: String,

    /**
     * The license of the component the code snippet is commit from.
     */
    val licenses: SpdxExpression,

    /**
     * A map for scanner specific snippet data that cannot be mapped into any generalized property, but still needs to
     * be made available in the scan summary.
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val additionalData: Map<String, String> = emptyMap()
)
