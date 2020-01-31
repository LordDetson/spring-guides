# Consuming a RESTful Web Service

### Description

You will build an application that uses Spring’s RestTemplate to retrieve a random Spring Boot quotation at https://gturnquist-quoters.cfapps.io/api/random.

**RestTemplate** makes interacting with most RESTful services a one-line incantation. And it can even bind that data to custom domain types.

**@JsonIgnoreProperties** from the Jackson JSON processing library is an annotation ,which indicate that any properties not bound in this type should be ignored.

To directly bind your data to your custom types, you need to specify the variable name to be exactly the same as the key in the JSON document returned from the API. In case your variable name and key in JSON doc do not match, you can use **@JsonProperty** annotation to specify the exact key of the JSON document.

Main line: `Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);`

[Guide Link](https://spring.io/guides/gs/consuming-rest/)
