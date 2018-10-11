package com.cn.connext.project.demo.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDateTime;

/*只有在使用SpringMVC的时候传到前端才会进行时间的格式化*/
public class LogTime {

    private LocalDateTime time;

    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    public LocalDateTime getTime() {
        return time;
    }

    @JsonDeserialize(using = JsonLocalDateTimeDeserializer.class)
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LogTime(){
        this.time=LocalDateTime.now();
    }

}
