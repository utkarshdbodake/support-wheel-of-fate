package com.zenpanda.handler.aws;

import com.zenpanda.entity.Schedule;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.Map;

public class SupportWheelOfFateFunctionHandler extends SpringBootRequestHandler<Map<String, String>, Schedule>{
}
