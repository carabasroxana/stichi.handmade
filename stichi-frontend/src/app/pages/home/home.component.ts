import { Component, OnInit }         from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import { RouterModule }              from '@angular/router';
import {TranslateModule, TranslateService} from '@ngx-translate/core';

import { HomeService }               from '../../services/home.service';
import { HomeDto, Product }          from '../../models/ home.model';

@Component({
  standalone: true,
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls:  ['./home.component.css'],
  imports: [
    CommonModule,
    RouterModule,
    TranslateModule,
    NgOptimizedImage
  ]
})
export class HomeComponent implements OnInit {
  welcomeMessage = '';
  totalProducts  = 0;
  subtitle       = '';
  featured: Product[] = [];
  today          = new Date();

  constructor(private homeSvc: HomeService,
              private translate: TranslateService) {}

  ngOnInit(): void {
    this.homeSvc.getHomeData().subscribe((data: HomeDto) => {
      this.welcomeMessage = data.welcomeMessage;
      this.subtitle       = data.subtitle;
      this.totalProducts  = data.totalProducts;
      this.featured       = data.featuredItems;
    });
  }

  openInstagram(): void {
    window.open('https://www.instagram.com/stichi.handmade', '_blank');
  }

  switchLang(): void {
    const next = this.translate.currentLang === 'ro' ? 'en' : 'ro';
    this.translate.use(next);
  }
}
