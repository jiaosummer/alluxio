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

package tachyon.worker.netty.protocol.buffer;

import java.nio.channels.FileChannel;

import io.netty.channel.DefaultFileRegion;

public class DataFileChannel extends DataBuffer {
  private final FileChannel mFileChannel;
  private final int mOffset;
  private final int mLength;

  public DataFileChannel(FileChannel fileChannel, int offset, int length) {
    mFileChannel = fileChannel;
    mOffset = offset;
    mLength = length;
  }

  @Override
  public Object getNettyOutput() {
    return new DefaultFileRegion(mFileChannel, mOffset, mLength);
  }

  @Override
  public int getLength() {
    return mLength;
  }
}
