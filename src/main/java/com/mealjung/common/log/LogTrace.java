package com.mealjung.common.log;

import com.mealjung.common.log.dto.TraceStatus;

public interface LogTrace {
    public TraceStatus begin(String message);
    public void end(TraceStatus status);
    public void exception(TraceStatus status, Exception e);

}


