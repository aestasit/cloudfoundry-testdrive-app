package com.aestas.blog.cloudfoundry.qa.data;

import com.aestas.blog.cloudfoundry.qa.mvc.WebPost;
import org.springframework.data.keyvalue.redis.core.StringRedisTemplate;
import org.springframework.data.keyvalue.redis.core.ValueOperations;
import org.springframework.data.keyvalue.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.keyvalue.redis.serializer.JdkSerializationRedisSerializer;

import javax.inject.Inject;
import javax.inject.Named;

// http://pietrowski.info/2011/01/spring-data-redis-tutorial/

@Named
public class RedisRepository {

    private final StringRedisTemplate template;
    private JacksonJsonRedisSerializer<WebPost> jsonRedisSerializer;
    private ValueOperations<String,String> valueOps;

    @Inject
	public RedisRepository(StringRedisTemplate template) {
		this.template = template;

        valueOps = template.opsForValue();
        jsonRedisSerializer = new JacksonJsonRedisSerializer<WebPost>(WebPost.class);
    }

    public void post(WebPost post) {
        final String serializedPost = new String(jsonRedisSerializer.serialize(post));
        valueOps.set(post.getName(), serializedPost);

    }

    public WebPost get(String nameKey) {
        return jsonRedisSerializer.deserialize(getAsJson(nameKey).getBytes());
    }

    public String getAsJson(String nameKey) {
        return valueOps.get(nameKey);
    }

}
