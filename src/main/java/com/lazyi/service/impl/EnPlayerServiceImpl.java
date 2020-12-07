package com.lazyi.service.impl;

import com.lazyi.mapper.EnPlayerMapper;
import com.lazyi.pojo.EnPlayer;
import com.lazyi.service.EnPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnPlayerServiceImpl implements EnPlayerService {

    @Autowired
    private EnPlayerMapper enPlayerMapper;

    @Override
    public List<EnPlayer> queryEnPlayerList() throws Exception{
        List<EnPlayer> enPlayers = enPlayerMapper.queryEnPlayerList();
        if(enPlayers.size() == 0) throw new Exception("No ENPlayer in DB");
        return enPlayers;
    }

    @Override
    public List<EnPlayer> queryEnPlayerByEnId(Integer enId) throws Exception{
        List<EnPlayer> enPlayers = enPlayerMapper.queryEnPlayerList();
        if(enPlayers.size() == 0) throw new Exception("No ENPlayer in DB");
        return enPlayers;
    }

    @Override
    public List<EnPlayer> addEnPlayer(Integer enId, Integer playerId) throws Exception{
        enPlayerMapper.addEnPlayer(enId, playerId);
        return enPlayerMapper.queryEnPlayerList();
    }

    @Override
    public void deleteEnPlayer(Integer enId, Integer playerId) throws Exception{
        enPlayerMapper.deleteEnPlayer(enId, playerId);
    }

    @Override
    public void deletePlayerEnrol(Integer enId) throws Exception{
        enPlayerMapper.deletePlayerEnrol(enId);
    }
}
