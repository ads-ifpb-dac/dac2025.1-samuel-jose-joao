package br.edu.ifpb.projeto.exceptions;

public class TicketNotFoundException extends RuntimeException
{
  public TicketNotFoundException(String message) {
    super(message);
  }
}
