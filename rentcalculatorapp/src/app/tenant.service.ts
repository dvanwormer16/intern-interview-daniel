import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tenant } from './tenant';

@Injectable({
    providedIn: 'root'
})
export class TenantService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public getTenants(): Observable<Tenant[]> {
        return this.http.get<Tenant[]>(`${this.apiServerUrl}/tenant/all`);
    }

    public addTenant(tenant: Tenant): Observable<Tenant> {
        return this.http.post<Tenant>(`${this.apiServerUrl}/tenant/add`, tenant);
    }

    public updateTenant(tenant: Tenant): Observable<Tenant> {
      return this.http.put<Tenant>(`${this.apiServerUrl}/tenant/update`, tenant);
    }

    public deleteTenant(tenantId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/tenant/delete/${tenantId}`);
    }
}
