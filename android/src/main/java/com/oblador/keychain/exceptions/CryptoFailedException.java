package com.oblador.keychain.exceptions;

import androidx.annotation.Nullable;

import java.security.GeneralSecurityException;

public class CryptoFailedException extends GeneralSecurityException {

  private int code;

  public CryptoFailedException(String message) {
    super(message);
  }

  public CryptoFailedException(String message, Throwable t) {
    super(message, t);
  }

  public static void reThrowOnError(@Nullable final Throwable error) throws CryptoFailedException {
    if(null == error) return;

    if (error instanceof CryptoFailedException)
      throw (CryptoFailedException) error;

    throw new CryptoFailedException("Wrapped error: " + error.getMessage(), error);

  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
