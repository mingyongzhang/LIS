package com.mlf.utils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityUtil {

	public StringWriter velocity(String template, VelocityContext context) {
		String fileDir = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		Properties properties = new Properties();
		VelocityEngine ve = new VelocityEngine();

		// 将当前路径设置到VelocityEngine 中
		properties.setProperty(ve.FILE_RESOURCE_LOADER_PATH, fileDir);
		properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
		properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");

		ve.init(properties);

		Template t = ve.getTemplate("/templates/" + template);

		StringWriter writer = new StringWriter();

		t.merge(context, writer);

		return writer;
	}

}
