import { Component, effect, signal } from '@angular/core';
import { ProductService, Product } from '../../services/product.service';
import {CurrencyPipe, NgFor, NgIf} from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-products',
  template: `
    <h2>Available products</h2>
    <section *ngIf="loading()">Loading…</section>

    <div class="grid gap-4 sm:grid-cols-2 md:grid-cols-3" *ngIf="!loading()">
      <article *ngFor="let p of products()"
               class="border rounded p-4 shadow">
        <img *ngIf="p.imageUrl" [src]="p.imageUrl" class="w-full h-48 object-cover mb-2">
        <h3 class="font-semibold">{{ p.name }}</h3>
        <p class="text-pink-700 font-bold">{{ p.price | currency }}</p>
      </article>
    </div>
  `,
  imports: [NgIf, NgFor, CurrencyPipe, CurrencyPipe],
})
export class ProductsComponent {
  products = signal<Product[]>([]);
  loading = signal(true);

  constructor() {
    const api = ProductService();
    effect(() => {
      api.list().subscribe({
        next: data => { this.products.set(data); this.loading.set(false); },
        error: err => console.error(err),
      });
    });
  }
}
