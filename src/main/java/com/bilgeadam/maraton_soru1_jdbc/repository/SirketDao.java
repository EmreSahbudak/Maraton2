package com.bilgeadam.maraton_soru1_jdbc.repository;

import com.bilgeadam.maraton_soru1_jdbc.entity.Calisan;
import com.bilgeadam.maraton_soru1_jdbc.entity.Sirket;
import com.bilgeadam.maraton_soru1_jdbc.util.DB;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class SirketDao {
    DB db=new DB();
    List<Object> list=new ArrayList<>();

    public void save(Sirket sirket){
        String sql="insert into sirket (sirketismi,sirketsahibi,sirketunvani,faliyetalani,kurulusyili) \n" +
                "values(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement=db.connection.prepareStatement(sql);
            preparedStatement.setString(1,sirket.getSirketIsmi());
            preparedStatement.setString(2,sirket.getSirketSahibi());
            preparedStatement.setString(3,sirket.getUnvani());
            preparedStatement.setString(4,sirket.getFaliyetAlani());
            preparedStatement.setInt(5,sirket.getKurulusYili());
            preparedStatement.executeUpdate();
            System.out.println(sirket.getSirketIsmi()+" isimli şirket veritabanına kaydedildi(sirketDao).");
            preparedStatement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
