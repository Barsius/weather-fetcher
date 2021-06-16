package com.nix.menshykov.weather.fetcher.impl.exception;

import com.nix.menshykov.weather.fetcher.impl.exception.mapper.ResponseExceptionMapperImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ResponseExceptionMapperImplTest {

    @Mock
    Response response;

    @Test
    public void fromResponse() {
        Mockito.when(response.getStatus()).thenReturn(404);
        Throwable thrown = new ResponseExceptionMapperImpl().fromResponse(response);
        assertEquals(thrown.getMessage(), "404: failed to load weather");
    }

}