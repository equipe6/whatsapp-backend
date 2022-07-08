package br.edu.unisinos.whatsapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message", schema = "public")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "message_entity_seq", sequenceName = "message_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_entity_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "message_to", nullable = false)
    private String to;

    @Column(name = "message_from", nullable = false)
    private String from;

    @Column(name = "message_body", nullable = false)
    private String body;

}
