package cl.mercadolibre.automationChallenge.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class Country implements Serializable {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("name")
    public String name;

}

