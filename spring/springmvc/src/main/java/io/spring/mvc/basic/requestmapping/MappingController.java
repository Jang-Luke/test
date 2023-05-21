package io.spring.mvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET) // 배열을 이용하여 다중 매핑도 가능
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mapping-get-v1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션
     *
     * @GetMapping
     * @PostMapping
     * @PutMappoing
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     * pathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @pathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    /**
     * pathVariable 다중 사용
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode,
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug"
     * params={"mode=debug", "data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * headers="mode,
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug"
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     *Accept 헤더 기반 Media Type
     * produces="text/html"
     * produces="!text/html"
     * produces="text/\*"
     * produces="*\/*"
     * produces={"text/plain", "application/*"}
     * produces=MediaType.TEXT_PLAIN_VALUE
     * produces="text/plain;charset=UTF=8"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
