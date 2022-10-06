# ELK

https://www.elastic.co/kr/downloads/elasticsearch


에러 발견
`received plaintext http traffic on an https channel, closing connection Netty4HttpChannel`

elasticsearch 경로로 이동 후 /config/elasticsearch.yml 아래와 같이 수정

```yaml
xpack.security.enabled: false
xpack.security.enrollment.enabled: false
xpack.security.http.ssl.enabled: false
xpack.security.transport.ssl.enabled: false
```


https://www.elastic.co/kr/downloads/kibana


https://www.elastic.co/kr/downloads/logstash

logstash 경로 이동 후 /bin 폴더 안에 logstash.conf 파일 추가


