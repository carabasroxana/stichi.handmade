import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HomeDto }    from '../models/ home.model';

@Injectable({ providedIn: 'root' })
export class HomeService {
  constructor(private http: HttpClient) {}

  getHomeData(): Observable<HomeDto> {
    return this.http.get<HomeDto>('/api/home');
  }
}
