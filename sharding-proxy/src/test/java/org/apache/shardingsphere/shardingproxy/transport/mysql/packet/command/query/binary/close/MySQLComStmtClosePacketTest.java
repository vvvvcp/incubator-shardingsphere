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

package org.apache.shardingsphere.shardingproxy.transport.mysql.packet.command.query.binary.close;

import com.google.common.base.Optional;
import org.apache.shardingsphere.shardingproxy.transport.mysql.packet.MySQLPacketPayload;
import org.apache.shardingsphere.shardingproxy.transport.common.packet.command.CommandResponsePackets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public final class MySQLComStmtClosePacketTest {
    
    @Mock
    private MySQLPacketPayload payload;
    
    @Test
    public void assertExecute() {
        when(payload.readInt4()).thenReturn(1);
        Optional<CommandResponsePackets> actual = new MySQLComStmtClosePacket(1, payload).execute();
        assertFalse(actual.isPresent());
    }
    
    @Test
    public void assertWrite() {
        when(payload.readInt4()).thenReturn(1);
        MySQLComStmtClosePacket actual = new MySQLComStmtClosePacket(1, payload);
        assertThat(actual.getSequenceId(), is(1));
        actual.write(payload);
    }
}
