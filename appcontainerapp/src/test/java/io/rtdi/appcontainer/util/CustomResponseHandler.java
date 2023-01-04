package io.rtdi.appcontainer.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

public class CustomResponseHandler implements HttpClientResponseHandler<ResponseData> {
	
	@Override
	public ResponseData handleResponse(ClassicHttpResponse response) throws HttpException, IOException {
		ResponseData data = new ResponseData();
		data.setStatus(response.getCode());
		try (HttpEntity httpEntity = response.getEntity(); InputStream inputStream = httpEntity.getContent()) {
			byte[] text = inputStream.readAllBytes();
			data.setPayload(new String(text, StandardCharsets.UTF_8));
			return data;
		}
	}
}