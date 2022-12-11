package com.demo.demodocconverter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.office.OfficeException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocConverterImpl implements DocConverter {
  private final DocumentConverter docConverter;

  @Override
  public Optional<byte[]> convert(byte[] document) {

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(document);

    try {
      docConverter
          .convert(byteArrayInputStream)
          .as(DefaultDocumentFormatRegistry.DOCX)
          .to(byteArrayOutputStream)
          .as(DefaultDocumentFormatRegistry.PDF)
          .execute();

      return Optional.ofNullable(byteArrayOutputStream.toByteArray());
    } catch (OfficeException e) {
      System.out.println(e.getMessage());
    }

    return Optional.empty();
  }
}
