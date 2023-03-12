package com.mealjung.common.log;

import com.mealjung.common.log.dto.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);

}


