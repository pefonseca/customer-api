package br.com.youtube.caio.customer.service.mapper;

public interface Mapper<A, B> {
    B map(A input);
}
