package top.javahai.chatroom.exception;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.javahai.chatroom.entity.RespBean;

import java.sql.SQLException;

/**
 * 功能：全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /*
  处理SQLException异常 MySQLIntegrityConstraintViolationException
   */
  @ExceptionHandler(SQLException.class)
  public RespBean sqlExceptionHandler(SQLException e){
    if (e instanceof MySQLQueryInterruptedException){
      return RespBean.error("该数据与其他数据存在关联，无法删除！");
    }
    else {
      e.printStackTrace();
      return RespBean.error("数据库异常，操作失败！");
    }
  }
}
