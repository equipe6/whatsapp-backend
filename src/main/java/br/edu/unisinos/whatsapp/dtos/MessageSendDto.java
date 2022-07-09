package br.edu.unisinos.whatsapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSendDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

}
