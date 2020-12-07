package com.lazyi.mapper;

import com.lazyi.pojo.EnPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnPlayerMapper {

    List<EnPlayer> queryEnPlayerList();

    List<EnPlayer> queryEnPlayerByEnId(Integer enId);

    void addEnPlayer(Integer enId, Integer playerId);

    void deleteEnPlayer(Integer enId, Integer playerId);

    void deletePlayerEnrol(Integer enId);
}
