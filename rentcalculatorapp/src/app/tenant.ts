export interface Tenant {
    assignCostOwed(): unknown;
    id: number;
    name: string;
    apartmentCost: number;
    apartmentFootage: number;
    totApartmentFootage: number;
    costOwed: number;
    imageUrl: string;
    tenantCode: string;
}
