/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package tachyon.client.file.policy;

import java.util.List;

import com.google.common.base.Preconditions;

import tachyon.client.block.BlockWorkerInfo;
import tachyon.client.file.options.OutStreamOptions;

/**
 * A default location policy that returns the hostname specified in the {@link OutStreamOptions}.
 */
public final class DefaultLocationPolicy implements FileWriteLocationPolicy {
  private OutStreamOptions mOptions;

  /**
   * Constructs the default location policy.
   */
  public DefaultLocationPolicy(List<BlockWorkerInfo> workerInfoList, OutStreamOptions options) {
    mOptions = Preconditions.checkNotNull(options);
  }

  @Override
  public String getWorkerForNextBlock(List<BlockWorkerInfo> workerInfoList) {
    return mOptions.getHostname();
  }
}
