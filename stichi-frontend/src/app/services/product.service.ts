import { inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Product {
  id: number;
  name: string;
  price: number;
  imageUrl?: string;
}

export function ProductService(baseUrl = 'http://localhost:8080/api') {
  const http = inject(HttpClient);
  const list = (): Observable<Product[]> => http.get<Product[]>(`${baseUrl}/products`);
  return { list };
}
