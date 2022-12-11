package com.demo.demodocconverter;

import java.util.Optional;
public interface DocConverter {

  public Optional<byte[]> convert(byte[] document);
}
