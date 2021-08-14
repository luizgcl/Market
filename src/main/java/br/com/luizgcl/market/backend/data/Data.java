package br.com.luizgcl.market.backend.data;

import java.util.List;

public interface Data<TData> {

    TData create(TData data);

    TData load(String barCode);

    List<TData> findByName(String name);

    void save(TData data);

}
