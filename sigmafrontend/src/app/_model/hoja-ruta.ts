import { Programacion } from './programacion';
import { ProgramaVisita } from './programavisita';
import { OrdenServicio } from './orden-servicio';

export class HojaRuta {
    public id_hoja_ruta: number;
    public activo: boolean;
    public descripcion: string;
    public fecha_creacion: Date;
    public fecha_eliminacion: Date;
    public fecha_modificacion: Date;
    public fecha_visita: Date;
    public orden: number;
    public referencia_ruta: string;
    public ubicacion: string;
    public longitud: string;
    public latitud: string;
    public usuario_creacion: number;
    public usuario_eliminacion: number;
    public usuario_modificacion: number;
    public programaVisita: ProgramaVisita;
    public ordenServicio: OrdenServicio;
}