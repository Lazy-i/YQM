package com.lazyi.service;

import com.lazyi.pojo.EnPlayer;

import java.util.List;

public interface EnPlayerService extends Service{

    List<EnPlayer> queryEnPlayerList() throws Exception;

    List<EnPlayer> queryEnPlayerByEnId(Integer enId) throws Exception;

    List<EnPlayer> addEnPlayer(Integer enId, Integer playerId) throws Exception;

    void deleteEnPlayer(Integer enId, Integer playerId) throws Exception;

    void deletePlayerEnrol(Integer enId) throws Exception;
}
