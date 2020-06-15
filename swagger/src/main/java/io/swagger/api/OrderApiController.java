package io.swagger.api;

import io.swagger.model.InlineResponse200;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-13T04:44:05.133Z[GMT]")
@Controller
public class OrderApiController implements OrderApi {

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<InlineResponse200>> orderOrderOrderNumberGet(@ApiParam(value = "order information",required=true) @PathVariable("orderNumber") String orderNumber
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<InlineResponse200>>(objectMapper.readValue("[ {\n  \"orderMenuItems\" : [ {\n    \"menuItemNumber\" : \"MENU-112\",\n    \"quantityOfMenuItem\" : 2,\n    \"menuName\" : \"Salmon\",\n    \"price\" : 12.95\n  }, {\n    \"m                \\"menuItemNumber\\"\" : \"MENU554\",\n    \"quantityOfMenuItem\" : 1,\n    \"menuName\" : \"Salad\",\n    \"”               \\"price\\"\" : 5.95\n  } ],\n  \"orderNumber\" : \"ORDER123\",\n  \"price\" : 31.85,\n  \"customerNumber\" : \"CUST456\"\n}, {\n  \"orderMenuItems\" : [ {\n    \"menuItemNumber\" : \"MENU-112\",\n    \"quantityOfMenuItem\" : 2,\n    \"menuName\" : \"Salmon\",\n    \"price\" : 12.95\n  }, {\n    \"m                \\"menuItemNumber\\"\" : \"MENU554\",\n    \"quantityOfMenuItem\" : 1,\n    \"menuName\" : \"Salad\",\n    \"”               \\"price\\"\" : 5.95\n  } ],\n  \"orderNumber\" : \"ORDER123\",\n  \"price\" : 31.85,\n  \"customerNumber\" : \"CUST456\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<InlineResponse200>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<InlineResponse200>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
