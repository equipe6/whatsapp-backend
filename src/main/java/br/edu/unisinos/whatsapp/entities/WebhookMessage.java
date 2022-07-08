package br.edu.unisinos.whatsapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "webhook_message", schema = "public")
public class WebhookMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "webhook_message_entity_seq", sequenceName = "webhook_message_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "webhook_message_entity_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "content_body", nullable = false)
    private String contentBody;

    @CreationTimestamp
    @Column(name = "create_date_time", nullable = false)
    private LocalDateTime createDateTime;

}
