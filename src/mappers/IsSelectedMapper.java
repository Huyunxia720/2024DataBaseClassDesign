package mappers;

import entity.IsSelected;

public interface IsSelectedMapper {
    IsSelected findFirstUnselected();
    int allSelected(); // �Ƴ��� @Select ע��
}