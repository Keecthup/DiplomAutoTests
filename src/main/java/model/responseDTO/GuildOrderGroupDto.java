package model.responseDTO;

import lombok.Data;

import java.util.List;

@Data

public class GuildOrderGroupDto {
    List<GuildOrder> guildOrders;
    Integer countPage;
}
