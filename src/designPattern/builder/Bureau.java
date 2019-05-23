/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.builder;

import designPattern.observer.Subject;

/**
 *
 * @author USER
 */
public class Bureau {

    protected int id;
    protected String sigle;
    protected String tel;
    protected String desc;

    private Bureau(BureauBuilder bb) {
        this.desc = bb.desc;
        this.tel = bb.tel;
        this.sigle = bb.sigle;
        this.id = bb.id;
    }

    public int getId() {
        return id;
    }

    public String getSigle() {
        return sigle;
    }

    public String getTel() {
        return tel;
    }

    public String getDesc() {
        return desc;
    }

    public static class BureauBuilder {

        protected int id;
        protected String sigle;
        protected String tel;
        protected String desc;

        public BureauBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public BureauBuilder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public BureauBuilder setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public BureauBuilder setSigle(String sigle) {
            this.sigle = sigle;
            return this;
        }

        public Bureau build() throws Exception {
            if (sigle == null || tel == null || desc == null) {
                throw new Exception("Informations de construction incomplètes");
            }
            return new Bureau(this);
        }
    }

    @Override
    public String toString() {
        return "Bureau{" + "id=" + id + ", sigle=" + sigle + ", tel=" + tel + ", desc=" + desc + '}';
    }

    

}
