import { Solicitud } from './solicitud';
export class OrdenServicio {
  public id_orden_servicio: number;
  public numero_orden:string;
  public solicitud: Solicitud;
  public activo: boolean;
  public usuario_creacion: string;
  public fecha_creacion: Date;
  public usuario_modificacion: string;
  public fecha_modificacion: Date;
  public usuario_eliminacion: string;
  public fecha_eliminacion: Date;
}