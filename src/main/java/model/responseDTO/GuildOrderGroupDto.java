package model.responseDTO;

import lombok.Data;

import java.util.List;

@Data
public class GuildOrderGroupDto {
    private List<GuildOrder> guildOrders;
    private Integer countPage;
}
