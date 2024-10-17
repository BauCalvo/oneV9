package bau.LoLSearch.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {
  private Status status;

  @Getter
  @Setter
  @ToString
  public static class Status{
    private int status_code;
    private String message;
  }
}
