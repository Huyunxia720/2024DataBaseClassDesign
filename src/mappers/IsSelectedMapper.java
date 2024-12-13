package mappers;

import entity.IsSelected;

public interface IsSelectedMapper {
    IsSelected findFirstUnselected();
    int allSelected(); // ÒÆ³ıÁË @Select ×¢½â
}