export interface Product {
  id: number;
  name: string;
  price: number;
  imageUrl: string;
}

export interface HomeDto {
  welcomeMessage: string;
  subtitle:       string;
  totalProducts: number;
  featuredItems: Product[];
}
