package com.yumi.jerrcode;

public interface ErrCode extends CodeInterface {
    Code SUCCESS = new Code(200, "成功");
    Code FAIL = new Code(400, "失败");
}
