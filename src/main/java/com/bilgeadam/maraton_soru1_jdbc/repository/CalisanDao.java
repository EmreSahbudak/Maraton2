package com.bilgeadam.maraton_soru1_jdbc.repository;

import com.bilgeadam.maraton_soru1_jdbc.entity.Calisan;
import com.bilgeadam.maraton_soru1_jdbc.entity.Sirket;
import com.bilgeadam.maraton_soru1_jdbc.util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CalisanDao {
    DB db=new DB();
    List<Object> list=new ArrayList<>();

    public void save(Calisan calisan){
        String sql="insert into calisan(calisanismi,yas,maas,departman,sirket_id) values(?,?,?,?,?) ";
        try{
            PreparedStatement preparedStatement=db.connection.prepareStatement(sql);
            preparedStatement.setString(1,calisan.getCalisanIsmi());
            preparedStatement.setInt(2,calisan.getYas());
            preparedStatement.setDouble(3,calisan.getMaas());
            preparedStatement.setString(4,calisan.getDepartman());
            preparedStatement.setInt(5,calisan.getSirket().getId());
            preparedStatement.executeUpdate();
            System.out.println(calisan.getCalisanIsmi()+" isimli çalısan database kaydedildi.(calisanDao)");
            preparedStatement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void getAll(){
        String sql="select c.id,c.calisanismi,c.yas,c.maas,c.departman,s.sirketismi,s.sirketsahibi,s.sirketunvani," +
                "s.faliyetalani,s.kurulusyili from calisan as c\n" +
                "inner join sirket as s on s.id=c.sirket_id";
        try{
            PreparedStatement preparedStatement=db.connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String calisanIsmi=rs.getString("calisanismi");
                int yas=rs.getInt("yas");
                double maas= rs.getDouble("maas");
                String departman= rs.getString("departman");
                String sirketIsmi=rs.getString("sirketismi");
                String sirketSahibi=rs.getString("sirketsahibi");
                String sirketUnvani=rs.getString("sirketunvani");
                String faliyetAlani=rs.getString("faliyetalani");
                int kurulusYili=rs.getInt("kurulusyili");
                Calisan calisan=new Calisan(id,calisanIsmi,yas,maas,departman,
                        new Sirket(sirketIsmi,sirketSahibi,sirketUnvani,faliyetAlani,kurulusYili));
                list.add(calisan);
            }
            if (list.isEmpty()){
                System.out.println("Liste boş");
            }else {
                list.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(int id){
        String sql="delete from calisan where id=?";
        try{
            PreparedStatement preparedStatement=db.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println(id+". li satır silindi(calisanDao).");
            preparedStatement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void update(int id,String abc){
        String sql="update calisan set departman=? where id=?";
        try{
            PreparedStatement preparedStatement=db.connection.prepareStatement(sql);
            preparedStatement.setString(1,abc);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            System.out.println(id+". li kayıt update edildi.(calisanDao)");
            preparedStatement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

















}
