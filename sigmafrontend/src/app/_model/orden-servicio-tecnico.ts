import { Tecnico } from './tecnico';
import { OrdenServicio } from './orden-servicio';
export class OrdenServicioTecnico {
  public id_orden_servicio_tecnico: number
  public ordenServicio: OrdenServicio
  public tecnico: Tecnico
  public observacion: string
  public comentario: string
  public activo: boolean
  public usuario_creacion: number
  public fecha_creacion: Date
  public usuario_modificacion: number
  public fecha_modificacion: Date
  public usuario_eliminacion: number
  public fecha_eliminacion: Date
}
